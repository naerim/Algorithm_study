function solution(date1, date2) {
    const year = date1[0]-date2[0]
    const month = date1[1]-date2[1]
    const day = date1[2]-date2[2]
    
    if (year > 0) return 0
    else if (year < 0) return 1
    else {
        if (month > 0) return 0
        else if (month < 0) return 1
        else {
            if (day >= 0) return 0
            else return 1
        }
    }
}