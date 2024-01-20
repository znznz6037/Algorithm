import Foundation

func solution(_ n:Int) -> Int {
    
    var num = 0
    for i in 1...n {
        num += 1
        while num % 3 == 0 || String(num).contains("3") {
            num += 1
        }
    }
    
    return num
}
