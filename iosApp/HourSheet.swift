//
//  HourlySheet.swift
//  iosApp
//
//  Created by Uche Godfrey on 6/2/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct HourSheet: View {
    @Binding var hours: [Int]
    @Environment(\.presentationMode) var presentationMode
    var body: some View {
        NavigationView {
            VStack {
                List {
                    ForEach(hours, id: \.self) {  hour in
                        Text("\(hour)")
                    }
                } // List
            } // VStack
            .navigationTitle("Found Meeting Hours")
            .toolbar {
                ToolbarItem(placement: .navigationBarTrailing) {
                    Button(action: {
                        presentationMode.wrappedValue.dismiss()
                    }) {
                        Text("Dismiss")
                            .frame(alignment: .trailing)
                            .foregroundColor(.black)
                    }
                } // ToolbarItem
            } // toolbar
        } // Navig
    }
}

#Preview {
    HourSheet(hours: .constant([8, 9, 10]))
}
