//
//  ListModifier.swift
//  iosApp
//
//  Created by Uche Godfrey on 4/27/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct ListModifier: ViewModifier {

    func body(content: Content) -> some View {
        if #available(iOS 15.0, *) {
            content
                .listRowInsets(.init())
                .listRowSeparator(.hidden)
        } else {
            content
        }
    }
}

extension View {
    func withListModifier() -> some View {
        modifier(ListModifier())
    }
}
