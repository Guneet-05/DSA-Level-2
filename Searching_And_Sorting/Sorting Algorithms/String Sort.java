int[] lowerCase = new int[26];
        int[] upperCase = new int[26];
        int[] digits = new int[10];
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch >= '0' && ch <= '9') {
                int idx = (int)(ch - '0');
                digits[idx]++;
            } else if(ch >= 'A' && ch <= 'Z') {
                int idx = (int)(ch - 'A');
                upperCase[idx]++;
            } else {
                int idx = (int)(ch - 'a');
                lowerCase[idx]++;
            }
        }
        
        StringBuilder sb = new StringBuilder("");
        
        for(int i=0;i<10;i++) {
            int freq = digits[i];
            while(freq-- > 0) {
                sb.append((char)(i + '0'));
            }
        }
        
        for(int i=0;i<26;i++) {
            int freq = upperCase[i];
            while(freq-- > 0) {
                sb.append((char)(i + 'A'));
            }
        }
        
        for(int i=0;i<26;i++) {
            int freq = lowerCase[i];
            while(freq-- > 0) {
                sb.append((char)(i + 'a'));
            }
        }
        
        return sb.toString();
