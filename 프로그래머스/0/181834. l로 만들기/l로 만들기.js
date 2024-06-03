function solution(myString) {
    const arr = ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"]
    return myString.split("").map(v => arr.includes(v) ? "l" : v).join("");
}