package src;

/**
 *
 * @author venceWEN
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int i,index;
        String subs="";
        int maxLen=0;
        int cLen=0;
        for(i=0;i<s.length();i++)
        {
        	if((index=subs.indexOf(s.charAt(i)))!=-1)
        	{
        		subs= subs.substring(index+1);
        		subs+= s.charAt(i);
        		cLen= cLen-index;
        	}
        	else
        	{
        		subs+= s.charAt(i);
        		cLen++;
        		if(cLen>maxLen)
        			maxLen=cLen;
        	}
        	System.out.println("subs: "+subs+",maxLen:"+maxLen);
        }
		return maxLen;
    }
    
    public void test()
    {
        String s="pwwkew";
    	System.out.println("result: "+ lengthOfLongestSubstring(s));
    }
}
