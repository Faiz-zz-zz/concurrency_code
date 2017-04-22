import random
import time
import datetime

def strTimeProp(start, end, format, prop):
    """Get a time at a proportion of a range of two formatted times.

    start and end should be strings specifying times formated in the
    given format (strftime-style), giving an interval [start, end].
    prop specifies how a proportion of the interval to be taken after
    start.  The returned time will be in the specified format.
    """

    stime = time.mktime(time.strptime(start, format))
    etime = time.mktime(time.strptime(end, format))

    ptime = stime + prop * (etime - stime)
    return ptime
    # return time.strftime(format, time.localtime(ptime))


def randomDate(start, end, prop):
    return strTimeProp(start, end, '%m/%d/%Y %I:%M %p', prop)

count = 0
array = []
total = 1000000
while count < total:
    a = randomDate("1/1/2008 1:30 PM", "1/1/2009 4:50 AM", random.random())
    print(a, datetime.datetime.utcfromtimestamp(a), count)
    array.append(datetime.datetime.utcfromtimestamp(a))
    count += 1

curr = time.time()
for date in array:
    datetime.datetime.strftime(date, '%m/%d/%Y %I:%M %p')

print((time.time() - curr) / total)
