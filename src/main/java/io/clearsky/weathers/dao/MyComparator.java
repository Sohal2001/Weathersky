package io.clearsky.weathers.dao;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import io.clearsky.weathers.entity.Weather;

public class MyComparator implements Comparator<Weather> {

	@Override
	public int compare(Weather ob1, Weather ob2) {
		String o1=ob1.getTimestamp();
		String o2=ob2.getTimestamp();
		
		Instant i = OffsetDateTime.parse(o1, DateTimeFormatter.ISO_DATE_TIME).toInstant();
        Timestamp ts = Timestamp.from(i);
        Instant i2 = OffsetDateTime.parse(o2, DateTimeFormatter.ISO_DATE_TIME).toInstant();
        Timestamp ts2 = Timestamp.from(i2);
        
        if(ts.getTime()>ts2.getTime()){
            return -1;
        }
        else if(ts.getTime()<ts2.getTime()){
            return +1;
        }
        else{
        	return 0;
        }
	}

}
