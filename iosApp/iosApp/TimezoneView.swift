//
//  TimezoneView.swift
//  iosApp
//
//  Created by Uche Godfrey on 4/27/24.
//  Copyright © 2024 orgName. All rights reserved.
//
import shared
import SwiftUI

struct TimezoneView: View {
    @EnvironmentObject private var timezoneItems: TimezoneItems
    private var timezoneHelper = TimeZoneHelperImpl()
    @State private var currentDate = Date()
    let timer = Timer.publish(every: 1000, on: .main, in: .common).autoconnect()
    @State private var showTimezoneDialog = false
    var body: some View {
        NavigationView {
          VStack {
            TimeCard(timezone: timezoneHelper.currentTimeZone(),
                     time: DateFormatter.short.string(from: currentDate),
                     date: DateFormatter.long.string(from: currentDate))
            Spacer()
           // TODO: Add List
          } // VStack
          .onReceive(timer) { input in
            currentDate = input
          }
          .navigationTitle("World Clocks")
          // TODO: Add toolbar
        } // NavigationView
    }
}

#Preview {
    TimezoneView()
}
