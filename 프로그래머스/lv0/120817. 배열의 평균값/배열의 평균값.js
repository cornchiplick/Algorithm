function solution(numbers) {
    let sum = 0;
    const len = numbers.length;
    console.log(len);
    for (let i = 0; i < numbers.length; i++) {
        sum += numbers[i];
    }
    
    return sum / len;
}