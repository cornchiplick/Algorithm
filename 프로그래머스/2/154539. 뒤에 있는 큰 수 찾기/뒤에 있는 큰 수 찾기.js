function solution(numbers) {
    const answer = new Array(numbers.length).fill(-1);
    const stack = [];
    for(var i =0;i<numbers.length;i++){
        while(stack&&numbers[stack.at(-1)]<numbers[i]){
            answer[stack.pop()] = numbers[i];
        }
        stack.push(i);
    }
    return answer;
}