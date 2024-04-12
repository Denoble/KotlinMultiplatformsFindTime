import SwiftUI
import shared

@main
struct iOSApp: App {
    let greeting = Greeting().greet()
	var body: some Scene {
		WindowGroup {
			ContentView()
           // Text(greeting)
		}
	}
}

/*struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}*/
