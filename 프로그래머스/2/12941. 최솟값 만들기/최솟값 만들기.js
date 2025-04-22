function solution(A,B){
    const sortedA = A.sort((a, b) => a-b);
    const sortedB = B.sort((a, b) => b-a);
    const value = A.reduce((acc, cur, index) => {
        return cur * B[index] + acc
    }, 0);
    return value;
}