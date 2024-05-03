//
//  ContentView.swift
//  iosApp
//
//  Created by Vengatesh on 07/03/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct ContentView: View {

    @State private var shouldOpenAbout = false
    
    var body: some View {
        let articlesScreen = ArticlesScreen(viewModel: .init())
        
        NavigationStack{
            articlesScreen
                .toolbar {
                    ToolbarItem {
                        Button {
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenAbout) {
                            AboutScreen()
                        }
                    }
                }
        }.refreshable {
            articlesScreen.viewModel.articlesViewModel.getArticles(forceFetch: true)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

