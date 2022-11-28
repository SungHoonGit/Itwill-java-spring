package net.testbean;

public class CalcBean {

  public int abs(int su){
    // 절대값 구하기(무조건 양수 출력)
    if(su<0)
      return -su;
    else
      return su;
}
  public int fact(int su){
    // 팩토리얼값 구하기 4*3*2*1
    return (su==0) ? 1 : su*fact(su-1);   
  }
}