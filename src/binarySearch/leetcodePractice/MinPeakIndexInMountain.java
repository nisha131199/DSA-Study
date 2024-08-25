package binarySearch.leetcodePractice;

public class MinPeakIndexInMountain {
    public static void main(String[] args) {
        MountainArray arr = new MountainArray() {
            int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82};
//            int[] arr = {1,2,3,4,5,3,1};
//            int[] arr = {1,5,2};

            @Override
            public int get(int index) {
                if (index>=0 && index<arr.length)
                    return arr[index];
                else return -1;
            }

            @Override
            public int length() {
                return arr.length;
            }
        };
        System.out.println(findInMountainArray(101, arr));
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int peekIndex = findPeekIndex(mountainArr);
        if (mountainArr.get(peekIndex) == target) return peekIndex;
        if (mountainArr.get(0)<=target) {
            int searchTargetIndex = doBinarySearch(mountainArr, target, 0, peekIndex-1, true);
            if (searchTargetIndex != -1)
                return searchTargetIndex;
            else
                return doBinarySearch(mountainArr, target, peekIndex+1, mountainArr.length()-1, false);
        }
        return doBinarySearch(mountainArr, target, peekIndex, mountainArr.length()-1, false);
    }

    public static int doBinarySearch(MountainArray mountainArr, int target, int s, int e, boolean asc) {
        while (s<=e) {
            int m = s + ((e-s)/2);
            if(mountainArr.get(m) == target) {
                return m;
            } else if(mountainArr.get(m) > target) {
                if (asc) e=m-1;
                else s=m+1;
            } else {
                if (asc) s=m+1;
                else e=m-1;
            }
        }
        return -1;
    }

    public static int findPeekIndex(MountainArray mountainArr) {
        int s=0,e=mountainArr.length()-1;
        while (s<e) {
            int m=s+((e-s)/2);
            if (mountainArr.get(m) < mountainArr.get(m + 1)) {
                s = m+1;
            } else {
                e = m;
            }
        }
        return s;
    }

     interface MountainArray {
        int get(int index);
        int length();
    }
}
