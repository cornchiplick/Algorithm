function solution(s) {
    const numArr = s.split(" ").map(num => Number(num));
    const biggest = numArr.reduce((acc, cur) => {
        if (acc >= cur) {
            return acc;
        } else {
            return cur;
        }
    }, numArr[0]);
    
    const smallest = numArr.reduce((acc, cur) => {
        if (acc < cur) {
            return acc;
        } else {
            return cur;
        }
    }, numArr[0]);
    
    return `${smallest} ${biggest}`;
}