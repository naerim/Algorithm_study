function solution(new_id) {
    const list = 'abcdefghijklmnopqrstuvwxyz0123456789-_.'

    // 1단계
    new_id = new_id.toLowerCase()
    // 2단계
    new_id = new_id.split("").map((v) => list.includes(v) ?  v :  '').join("")
    // 3단계
    while(new_id.includes("..")) {
        new_id = new_id.replaceAll("..", ".")
    }
    // 4단계
    if(new_id[0] === '.') new_id = new_id.slice(1)
    if(new_id[new_id.length-1] === '.') new_id = new_id.slice(0, new_id.length-1)
    // 5단계
    if(new_id === "") new_id = "a"
    // 6단계
    if(new_id.length >= 16) {
        new_id = new_id.slice(0, 15)
        if(new_id[new_id.length-1] === '.') new_id = new_id.slice(0, new_id.length-1)
    }
    // 7단계
    if(new_id.length <= 2) {
        let last = new_id[new_id.length-1] // 마지막 문자
        new_id = new_id + last.repeat(3-new_id.length)
    }

    return new_id;
}