function solution(people, limit) {
    people.sort((a,b) => a-b);
    let count = 0;
    
    while (people.length) {
        if (people[0] + people.at(-1) <= limit) {
            people.shift();
            people.pop();
            count++;
        } else {
            people.pop();
            count++;
        }
    }
    return count;
}