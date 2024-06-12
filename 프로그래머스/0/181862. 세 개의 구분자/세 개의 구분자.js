function solution(myStr) {
    var answer = [];
    const arr1 = myStr.split("a").filter(v=> v !== "")
    let arr2 = []
    arr1.forEach(v => {
        if(v.includes("b")) {
            let arr = v.split("b")
            arr.forEach((v) => {if(v!=="") arr2.push(v)})
        } else arr2.push(v)
    })
    let arr3 = []
        arr2.forEach(v => {
        if(v.includes("c")) {
            let arr = v.split("c")
            arr.forEach((v) => {if(v!=="") arr3.push(v)})
        } else arr3.push(v)
    })
    
    if(arr3.length===0) arr3.push("EMPTY")

    return arr3;
}