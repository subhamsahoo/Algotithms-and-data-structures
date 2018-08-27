/*

Implement pow(x, n) % d.

In other words, given x, n and d,

find (xn % d)

Note that remainders on division cannot be negative. 
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.

*/

/**
 * @input x : Integer
 * @input n : Integer
 * @input d : Integer
 * 
 * @Output Integer
 */
 
 long long MOD(long long  a, long long b){
    return (a%b + b)%b;
}

 
int powmod(int x, int n, int d) {
        if(n==0 & x==0) return 0;
    if(n == 0) return 1;
    if(n == 1) return MOD(x,d);
    
    if(n%2 == 0){
        long long y = MOD(powmod(x, n/2, d),d);
        
        return MOD( y*y ,d);
    }
    else{
        return MOD( MOD(powmod(x, n-1, d),d) * MOD(x,d), d);
    }
}
