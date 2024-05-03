//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Vengatesh on 07/03/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

extension ArticlesScreen {
    
    @MainActor
    class ArticlesViewModelWrapper : ObservableObject {
        @Published var articlesState: ArticlesState
        
        let articlesViewModel: ArticlesViewModel
        
        init() {
            articlesViewModel = ArticlesInjector().articlesViewModel
            articlesState = articlesViewModel.articlesState.value
        }
        
        func startObserving() {
            Task {
                for await articlesS in articlesViewModel.articlesState {
                    self.articlesState = articlesS
                }
            }
        }
    }
}

struct ArticlesScreen : View {
    
    @ObservedObject private(set) var viewModel: ArticlesViewModelWrapper
    
    var body: some View {
        VStack {
            AppBar()
            
            if viewModel.articlesState.loading {
                Loader()
            }
            if let error = viewModel.articlesState.error {
                ErrorMessage(message: error)
            }
            if(!viewModel.articlesState.articles.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.articlesState.articles, id: \.self) { article in
                            ArticleItemView(article: article)
                        }
                    }
                }
            }
        }.onAppear{
            self.viewModel.startObserving()
        }
    }
}

struct ArticleItemView: View {
    
    var article: Article
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8){
            let url = convertToInsecureUrl(url: article.imageUrl) ?? ""
            AsyncImage(url: URL(string: url)){ phase in
                if phase.image != nil {
                    phase.image!.resizable().aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Error loading image: \(String(describing: phase.error?.localizedDescription))")
                } else {
                    ProgressView()
                }
            }
            Text(article.title)
                .font(.body)
                .fontWeight(.bold)
            Text(article.desc)
                .font(.body)
            Text(article.date)
                .frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
        }
        .padding(16)
    }
}

struct AppBar: View {
    var body: some View {
        Text("Articles")
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct Loader : View {
    var body: some View {
        ProgressView()
    }
}

struct ErrorMessage : View {
    let message: String
    var body: some View {
        Text(message)
            .font(.title)
    }
}

func convertToInsecureUrl(url: String) -> String? {
    guard var urlComponents = URLComponents(string: url) else { return nil }
    urlComponents.scheme = "http"
    return urlComponents.url?.absoluteString
}
