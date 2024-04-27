//
//  CardModifier.swift
//  iosApp
//
//  Created by Uche Godfrey on 4/26/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
struct CardModifier: ViewModifier {
  func body(content: Content) -> some View {
    content
      .cornerRadius(16)
      .shadow(color: Color.black.opacity(0.2), radius: 16, x: 0, y: 0)
  }
}
