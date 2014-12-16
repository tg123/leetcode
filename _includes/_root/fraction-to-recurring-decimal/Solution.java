public class Solution {
    
    public String fractionToDecimal(int numerator, int denominator) {

        String sign = "";
        
        if(Math.signum(numerator) * Math.signum(denominator) < 0){
            sign = "-";
        }

        // cheat ...
        long _numerator = numerator;
        
        long quotient = _numerator / denominator;
            
        _numerator %= denominator;
        _numerator *= 10;
        
        final String intPart = "" + Math.abs(quotient);
        
        Map<String, Integer> mod = new HashMap<String, Integer>();
        
        int i = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(_numerator != 0){
            quotient = Math.abs(_numerator / denominator);
            
            _numerator %= denominator;
            
            Integer start = mod.get(_numerator + "," + quotient);
            
            if(start != null){
                sb.insert(start, "(");
                sb.append(")");
                break;
            }
            
            sb.append(quotient);
            
            mod.put(_numerator + "," + quotient, i);
            
            _numerator *= 10;
            i++;
        }
        
        String fractionalPart = sb.toString();

        if(!"".equals(fractionalPart)) fractionalPart = "." + fractionalPart;
        
        return sign + intPart + fractionalPart;
        
    }
}
