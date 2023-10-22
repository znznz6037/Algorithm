import Foundation

func solution(_ players:[String], _ callings:[String]) -> [String] {
    
    var result: [String] = players
    var dict: [String: Int] = [:]
    
    for i in 0...players.count - 1 {
        dict[players[i]] = i
    }
    
    for call in callings {
        if let rank = dict[call] {
            let name = result[rank - 1]
            result[rank - 1] = call
            result[rank] = name
            
            dict[call] = rank - 1
            dict[name] = rank
        }
    }
    
    return result
}
