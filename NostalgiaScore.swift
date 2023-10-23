import Foundation

func solution(_ name:[String], _ yearning:[Int], _ photo:[[String]]) -> [Int] {
    var dict: [String: Int] = [:]
    var scores: [Int] = []
    
    for i in name.indices {
        dict[name[i]] = yearning[i]
    }
    
    for i in photo.indices {
        var score = 0
        for j in photo[i].indices {
            var nameStr = photo[i][j]
            if let num = dict[nameStr] {
                score += num
            }
        }
        
        scores.append(score)
    }
    
    return scores
}
