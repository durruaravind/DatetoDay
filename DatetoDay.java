// Code to calculate the DAY for a specific DATE given as input
// This class method is invoked when the Applet GUI invokes the DateDay method
// This code works on the method of odd days calculation. Reference video tutorial: https://www.youtube.com/watch?v=KgOhcg92Fdc

public class DatetoDay
{
    public static String DateDay(int x, int y, int z)
    {
        // x, y, z are sent as input for date, year, and month respectively

        int day= x;
        int month= y;
        int year= z;
        int sum= 0; // This variable stores the no. of remaining odd days
        int temp_year= year-1;
        int odd_days_of_years[][]={{400,300,200,100},{0,1,3,5}};

        for(int i=4;i>=1;i--)
        {
            if(temp_year/(i*100)!=0)
            {
                sum+= odd_days_of_years[1][4-i];
                temp_year= temp_year%(i*100);
            }
        }
        
        int rem_leapyears= temp_year/4;
        int rem_normalyears= temp_year-rem_leapyears;
        sum+= ((rem_leapyears*2)+rem_normalyears)%7;
        
        //current year is checked if leap year
        boolean leap= false;
        if (year % 4 == 0)
        {
            // if the year is century
            if (year % 100 == 0) 
            {

                // if year is divided by 400 then it is a leap year
                if (year % 400 == 0)
                leap= true;
                else
                leap= false;
            }
            // if the year is not century
            else
                leap= true;
        }
        else
        leap= false;
        
        int odd_days_of_months[]={3,0,3,2,3,2,3,3,2,3,2,3};
        if(leap)
        odd_days_of_months[1]=1; 
        
        int temp_sum= day;
        for(int i=0;i<month-1;i++)
        {
            temp_sum+= odd_days_of_months[i];
        }
        sum+= (temp_sum%7);

        String odd_days_of_days[]={"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};

        // Returning final result
        if(sum<7)
        return(odd_days_of_days[sum]); 
        else
        {
            return(odd_days_of_days[sum%7]);
        }
    }
}