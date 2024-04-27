//
//  Utils.swift
//  iosApp
//
//  Created by Uche Godfrey on 4/27/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
extension DateFormatter {
    static let short: DateFormatter = {
        let formatter = DateFormatter()
        formatter.dateStyle = .none
        formatter.timeStyle = .short
        return formatter
    }()
    static let long: DateFormatter = {
        let formatter = DateFormatter()
        formatter.dateStyle = .long
        formatter.timeStyle = .none
        return formatter
    }()
}
