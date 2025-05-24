function solution(k, tangerine) {
    let hashMap = new Map();
    for(let i = 0; i <tangerine.length; i++) {
        hashMap.set(tangerine[i], (hashMap.get(tangerine[i]) || 0) +1)
    }
    
    const sortedMap = [...hashMap].sort((a, b) => b[1] - a[1]);
    let tempSum = 0, i = 0;
    while(tempSum < k) {
        if(sortedMap[i][1] >= k) {
            return i+1
        } else {
            tempSum+=sortedMap[i][1];
            i++
        }
    }
    
    return i
}