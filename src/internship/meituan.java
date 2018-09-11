package internship.wangyi;

import java.util.*;

public class meituan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        List<Space> spaces = new ArrayList<>();
        List<Allocation> allocations = new ArrayList<>();
        int memory[] = new int[M];
        spaces.add(new Space(0, M));
        for (int i = 1; i <= N; i++) {
            int size = scanner.nextInt();
            if (size <= 0 || size > M) {
                System.out.println("SKIP: " + i + " " + size);
            } else {

                int begin = getBegin(spaces, size,M);
                if (begin == -1) {
                    begin = 0;
                    for (Allocation allocation : allocations) {
                        if (M - allocation.begin >= size) {
                            begin = allocation.begin;
                            break;
                        }
                    }
                }

                allocations.add(new Allocation(i,begin));
                Set<Integer> set = new HashSet<>();
                int lastPoint1 = begin + size;
                int lastPoint2 = lastPoint1;
                if (lastPoint1 < M) {
                    int deleteNum = memory[lastPoint1 - 1];
                    for (int k = lastPoint1; k < M; k++) {
                        if (memory[k] == 0 || memory[k] != deleteNum) {
                            lastPoint2 = k;
                            break;
                        }else{
                            memory[k] = 0;
                        }
                    }
                }
                // 删除的区间为lastPoint1 - lastPoint2
                adjustSpace(spaces, begin, begin + size, lastPoint1, lastPoint2);
                // 需要被抹掉的数据
                for (int j = begin; j < begin + size; j++) {
                    set.add(memory[j]);
                    memory[j] = i;
                }

                deleteAllocation(allocations, set);

            }
        }
        for (Allocation allocation : allocations){
            System.out.println(allocation.i +" "+ allocation.begin);
        }
    }

    private static void adjustSpace(List<Space> spaces, int begin, int end, int lastPoint1, int lastPoint2) {
        if (lastPoint2 > lastPoint1) {
            if (spaces.size()==0||lastPoint2 <spaces.get(0).begin){
                spaces.add(0,new Space(lastPoint1, lastPoint2));
            }else {
                for (int i = 0; i < spaces.size(); i++) {
                    if (lastPoint2 == spaces.get(i).begin) {
                        spaces.get(i).begin = lastPoint1;
                    } else if (lastPoint1 > spaces.get(i).last) {
                        spaces.add(i+1,new Space(lastPoint1, lastPoint2));
                        i++;
                    }
                }
            }
        }
        if (spaces.size() != 0) {
            for (int i = 0; i < spaces.size(); i++) {
                if (spaces.get(i).begin >= end && spaces.get(i).last <= begin) {
                    continue;
                } else {
                    if (spaces.get(i).begin >= begin) {
                        if (spaces.get(i).last <= end) {
                            spaces.remove(i);
                            i--;
                        } else {
                            if(spaces.get(i).begin < end) {
                                spaces.get(i).begin = end;
                            }
                        }
                    }
                }
            }
        }

    }

    private static void deleteAllocation(List<Allocation> allocations, Set<Integer> set) {
        for (Integer delete : set) {
            for (int j = 0; j < allocations.size(); j++) {
                if (allocations.get(j).i == delete) {
                    allocations.remove(j);
                    break;
                }
            }
        }
    }

    private static int getBegin(List<Space> list, int needSpace,int M) {
        for (Space space : list) {
            if (M-space.begin >= needSpace) {
                return space.begin;
            }
        }

        return -1;
    }

    static class Allocation {
        int i;
        int begin;

        Allocation(int i, int begin) {
            this.i = i;
            this.begin = begin;
        }
    }

    static class Space {
        int begin;
        int last;

        Space(int begin, int last) {
            this.begin = begin;
            this.last = last;
        }
    }
}

