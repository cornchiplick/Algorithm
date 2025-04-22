function solution(s) {
    const wordArr = s.split(" ");
    const newArr = wordArr.map(word => {
        const first = word.substring(0, 1);
        const rest = word.substring(1);
        return `${first.toUpperCase()}${rest.toLowerCase()}`;
    });
    return newArr.join(" ");
}