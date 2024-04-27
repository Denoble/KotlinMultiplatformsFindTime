//
//  TimezoneItems.swift
//  iosApp
//
//  Created by Uche Godfrey on 4/27/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

import SwiftUI
import shared

class TimezoneItems: ObservableObject {
  @Published var timezones: [String] = []
  @Published var selectedTimezones = Set<String>()

  init() {
      self.timezones = TimeZoneHelperImpl().getTimeZoneStrings()
  }
}
