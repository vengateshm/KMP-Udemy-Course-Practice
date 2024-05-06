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
    @State private var isDarkTheme = false
        
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
                    ToolbarItem {
                        Button {
                            articlesScreen.viewModel.articlesViewModel.setIsDarkTheme(value: !isDarkTheme)
                        } label: {
                            if isDarkTheme {
                                Label("Light", systemImage: "sun.max")
                            } else {
                                Label("Dark", systemImage: "moon.circle")
                            }
                        }
                    }
                }
        }.refreshable {
            articlesScreen.viewModel.articlesViewModel.getArticles(forceFetch: true)
        }.onAppear {
            Task {
                for await themeValue in articlesScreen.viewModel.articlesViewModel.appDatastore().isDarkTheme() {
                    self.isDarkTheme = themeValue.boolValue
                    print(themeValue.boolValue)
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

