public class Solution {
    
    static class Word {

        String word;
        Set<Word> next;

        boolean end;

        Word(String word){
            this.word = word;
        }
    }

    static class Trace {

        Word obj;
        Trace prev;

        Trace(Word obj,Trace prev){
            this.obj  = obj;
            this.prev = prev;
        }
    }


    HashMap<String, Word> wmap;

    void connect(Word w, Set<String> dict){
        if(w.next != null) return;

        Set<Word> n = new HashSet<Word>();

        char[] ws = w.word.toCharArray();

        for(int i = 0; i < ws.length; i++){
            char t = ws[i];

            for(char r = 'a'; r <= 'z'; r++){
                ws[i] = r;

                String d = new String(ws);
                if(dict.contains(d)){
                    Word c = wmap.get(d);
                    n.add(c);
                }
            }

            ws[i] = t;
        }

        w.next = n;
    }


    public List<List<String>> findLadders(String start, String end, Set<String> dict) {


        List<List<String>> rt = new ArrayList<List<String>>();

        wmap = new HashMap<String, Word>();

        for(String d : dict){
            Word w = new Word(d);
            wmap.put(d, w);
        }

        Word _end = new Word(end);
        _end.end = true;
        wmap.put(end, _end);

        // help to connected to end
        dict.add(end);


        final Trace SEP = new Trace(null, null);
        LinkedList<Trace> queue = new LinkedList<Trace>();
        
        queue.add(new Trace(new Word(start), null));
        queue.add(SEP);

        boolean found = false;

        HashSet<Word> vi = new HashSet<Word>();
        HashSet<Word> svi = new HashSet<Word>();

        while(!queue.isEmpty()){

            Trace step = queue.poll();

            if(step == SEP) {
                vi.addAll(svi);
                svi.clear();
                
                if (found) break;
                if (!queue.isEmpty()) queue.add(SEP);
                
            } else {

                Word word = step.obj;
                connect(word, dict);
    
                
                if(word.end){
    
                    LinkedList<String> r = new LinkedList<String>();
    
    
                    Trace t = step;
    
                    while (t != null){
                        r.addFirst(t.obj.word);
                        t = t.prev;
                    }
    
                    rt.add(r);
    
                    found = true;
                    
                }else if(!found){ // prevent deeper level to be visited
    
                    for (Word p : word.next) {
    
                        if(!vi.contains(p)) {
                            queue.add(new Trace(p, step));
                            svi.add(p);
                        }
                    }
                }
            }
        }


        return rt;
    }
}
