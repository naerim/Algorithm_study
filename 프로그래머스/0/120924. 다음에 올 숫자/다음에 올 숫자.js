function solution(common) {

    if(common[1]-common[0] === common[2]-common[1]) {
        let d = common[1]-common[0]
        return common[common.length-1] + d
    } else {
        let d = common[1]/common[0]
        return common[common.length-1]*d
    }
    
}