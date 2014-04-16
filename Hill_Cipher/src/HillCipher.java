import java.math.*;
public class HillCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HillCipher hc=new HillCipher();
		hc.findkey();
	}
	public void findkey(){
		int count;
		String encryp_txt="Kxtcgobhpmjq";
		String plain_txt="TheLionKingx";
		int[][] key=new int[2][2];
		int[][] plain=new int[2][2];
		int[][] encryp=new int[2][2];
		BigInteger det= new BigInteger("0");
		BigInteger m = new BigInteger("26");
		int det_plain;
		count=0;
		encryp_txt=encryp_txt.toLowerCase();
		plain_txt=plain_txt.toLowerCase();
		for (int b=0 ; b<=1 ; b++)
		{
			for (int a=0 ; a<=1 ; a++)
			{
				
				plain[a][b]=(int)plain_txt.charAt(count)-97;
				encryp[a][b]=(int)encryp_txt.charAt(count)-97;
				count++;
			}
		}
		det_plain=(plain[1][1]*plain[0][0])-(plain[0][1]*plain[1][0]);
		try{
			det= BigInteger.valueOf(det_plain).modInverse(m);

		}catch(Exception e){
			System.out.println("Invalid plain or cipher text");
		}
		det_plain=det.intValue();
		int temp1=plain[0][0];
		int temp2=plain[1][1];
		plain[0][0]=(temp2*det_plain)%26;
		plain[1][1]=(temp1*det_plain)%26;
		plain[1][0]=((-(plain[1][0]))*det_plain)%26;
		plain[0][1]=((-(plain[0][1]))*det_plain)%26;
		
		for (int b=0 ; b<=1 ; b++)
		{
			for (int a=0 ; a<=1 ; a++)
			{
				if(plain[a][b]<0)
				{
					plain[a][b]+=26;
				}
			}
		}
		
		int a=0,b=0;

		key[a][b]=(encryp[a][b]*plain[a][b])+(encryp[a][b+1]*plain[a+1][b]);
		key[a][b+1]=(encryp[a][b]*plain[a][b+1])+(encryp[a][b+1]*plain[a+1][b+1]);
		key[a+1][b]=(encryp[a+1][b]*plain[a][b])+(encryp[a+1][b+1]*plain[a+1][b]);
		key[a+1][b+1]=(encryp[a+1][b]*plain[a][b+1])+(encryp[a+1][b+1]*plain[a+1][b+1]);
		
		
		key[a][b]=key[a][b]%26;
		key[a][b+1]=key[a][b+1]%26;
		key[a+1][b]=key[a+1][b]%26;
		key[a+1][b+1]=key[a+1][b+1]%26;
		System.out.println("-------------Key------------");
		for (int x=0 ; x<=1 ; x++)
		{
			System.out.println("\n");
			for (int y=0 ; y<=1 ; y++)
			{
				System.out.print("\t"+key[x][y]+"\t");
			}
			
		}
	}

}
