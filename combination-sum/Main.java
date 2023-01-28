import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args){
        List<List<Integer>> results = (new Solution()).combinationSum(new int[]{2, 3, 7}, 18);
        System.out.println(results.toString());
    }
}

class Solution {
    private int remainder;
    private int currentIndex;
    private List<Integer> candidatesSum;
    private int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        this.candidates = candidates;

        for (int i = 0; i < candidates.length; i++) {
            int localCandidate = candidates[i];

            for (int j = 0; j < candidates.length; j++) {
                currentIndex = j;
                remainder = target - localCandidate;
                candidatesSum =  new ArrayList<>();
                candidatesSum.add(localCandidate);

                if(this.divide()){
                    results.add(candidatesSum);
                }
            }
        }

        return results;
    }

    private boolean divide(){

        if(currentIndex >= candidates.length){
            return false;
        }

        int localCandidate = candidates[currentIndex];

        if(remainder == 0) return true;

        if(remainder < localCandidate) return false;

        int loopCount = remainder / localCandidate;
        for(int i = 0; i < loopCount; i++) {
            candidatesSum.add(localCandidate);
            remainder -= localCandidate;
        }
        currentIndex++;

        if(remainder == 0) {
            return true;
        }
//
//            currentIndex++;
//
//        for(int i = 0; i < remainder/)
//        remainder -= localCandidate;
//        candidatesSum.add(localCandidate);

        return divide();
    }
}


//class Solution {
//    private int remainder;
//    private int currentIndex;
//    private List<Integer> candidatesSum;
//    private int[] candidates;
//    private int localCandidate;
//    private int target;
//    private int innerLoopStartIndex = 0;
//    private List<List<Integer>> results = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        this.candidates = candidates;
//        this.target = target;
//
//        for (int i = 0; i < candidates.length; i++) {
//            this.localCandidate = candidates[i];
//            this.recursionForTheSameCandidateNDN(candidates[i], 1);
//            System.out.println('\n');
//            this.innerLoopStartIndex = i;
//        }
//
//        return results;
//    }
//
//    private boolean divide(){
//
//        if(currentIndex >= candidates.length){
//            return false;
//        }
//
//        int localCandidate = candidates[currentIndex];
//
//        if(remainder == 0) return true;
//
//
//        if(remainder < localCandidate) return false;
//
//        if(remainder % localCandidate == 0){
//            for(int i = 0; i < (remainder / localCandidate); i++) candidatesSum.add(localCandidate);
//            currentIndex++;
//            return true;
//        }
//
//        currentIndex++;
//
//        for(int i = 0; i < remainder /localCandidate; i++){
//            remainder -= localCandidate;
//            candidatesSum.add(localCandidate);
//        }
//
//        return divide();
//    }
//
//    private void recursionForTheSameCandidateNDN(int localCandidate, int recursionCount){
//
//        if(localCandidate * recursionCount > target) return;
//
//        List<Integer> localCandidatesSum = new ArrayList<>();
//        this.remainder = this.target - recursionCount * localCandidate;
//
//        for(int i = 0; i < recursionCount; i++) localCandidatesSum.add(localCandidate);
//
//        for(int i = this.innerLoopStartIndex; i < candidates.length; i++) {
//            currentIndex = i;
//            candidatesSum = new ArrayList<>(localCandidatesSum);
//
//            if (this.divide()) {
//                this.results.add(candidatesSum);
//                System.out.print(candidatesSum.toString());
//            }
//        }
//
//        this.recursionForTheSameCandidateNDN(localCandidate, ++recursionCount);
//    }
//}
