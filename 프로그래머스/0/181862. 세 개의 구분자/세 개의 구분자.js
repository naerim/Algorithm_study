function solution(myStr) {
    const arr = myStr.split(/[abc]/g).filter(v => v!=="")
    return arr.length ? arr : ["EMPTY"];
}