public class Solution {
    static int li(int[] building){
        return building[0];
    }

    static int ri(int[] building){
        return building[1];
    }

    static int hi(int[] building){
        return building[2];
    }

    static class SortedBuilds {
        int[][] buildings;
        int p = 0;

        PriorityQueue<int[]> inserted = new PriorityQueue<>((a, b) -> li(a) - li(b));

        SortedBuilds(int[][] buildings) {
            this.buildings = buildings;
        }

        boolean hasNext(){
            return p < buildings.length || !inserted.isEmpty();
        }


        int[] next(){

            if(p < buildings.length && !inserted.isEmpty()){

                if(li(buildings[p]) < li(inserted.peek())){
                    return buildings[p++];
                }else{
                    return inserted.poll();
                }

            } else if(p < buildings.length ){
                return buildings[p++];
            } else { // !inserted.isEmpty())
                return inserted.poll();
            }

        }

        void insert(int[] building){
            inserted.add(building);
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {

        List<int[]> all = new ArrayList<>();
        if(buildings.length == 0) return all;

        SortedBuilds sortedBuilds = new SortedBuilds(buildings);

        int[] a = sortedBuilds.next();

        while (sortedBuilds.hasNext()){
            int[] b = sortedBuilds.next();

            if(ri(a) == li(b) && hi(a) == hi(b)){
                a = new int[]{li(a), ri(b), hi(a)};
                continue;
            }

            // a.r b.l
            if(ri(a) <= li(b)){
                all.add(new int[]{li(a), hi(a)});

                if(ri(a) < li(b)){
                    all.add(new int[]{ri(a), 0});
                }

                a = b;
                continue;
            }

            // a.l b.l
            if(li(a) == li(b)){

                // make a higher than b
                if(hi(a) < hi(b)){
                    sortedBuilds.insert(a);
                    a = b;
                    continue;
                }

                if(ri(a) < ri(b)){
                    sortedBuilds.insert(new int[]{ri(a), ri(b), hi(b)});
                }
                // else drop b (b inside a)
                continue;
            }

            //
            if(hi(a) < hi(b)){

                all.add(new int[]{li(a), hi(a)});

                if(ri(a) > ri(b)){
                    sortedBuilds.insert(new int[]{ri(b), ri(a), hi(a)});
                }

                a = b;
                continue;
            }

            // a.h >= b.h

            if(ri(a) < ri(b)){
                sortedBuilds.insert(new int[]{ri(a), ri(b), hi(b)});
            }
            // else drop b (b inside a)
        }

        all.add(new int[]{li(a), hi(a)});
        all.add(new int[]{ri(a), 0});

        return all;
    }
}
