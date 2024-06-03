//
//  ContentView.swift
//  iosApp
//
//  Created by Uche Godfrey on 4/27/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct ContentView: View {
    @StateObject private var timezoneItems = TimezoneItems()
    var body: some View {
            TabView {
              TimezoneView()
                .tabItem {
                  Label("Time Zones", systemImage: "network")
                }
            
              FindMeeting()
                .tabItem {
                 Label("Find Meeting", systemImage: "clock")
               }
            }
            .accentColor(Color.white)
            .environmentObject(timezoneItems)
          }
    }


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
