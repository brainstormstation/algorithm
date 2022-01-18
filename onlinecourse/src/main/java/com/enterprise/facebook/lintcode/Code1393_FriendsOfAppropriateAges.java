package com.enterprise.facebook.lintcode;

/**
 * Description
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.
 * If any of the following conditions is met, A will not make a friend request to B (b! =A):

age[B] <= 0.5 * age[A] + 7
age[B] > age[A]
age[B] > 100 && age[A] < 100
Otherwise, A will send a friend request to B.

Note that if A requests B, B does not necessarily request A. Also, people will not friend request themselves.

How many friend requests have been sent?
 */
public class Code1393_FriendsOfAppropriateAges {
    /**
     * @param ages: 
     * @return: nothing
     */
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }

        int ans = 0;
        int[] numAges = new int[121];
        int[] sumAges = new int[121];
        for (int age: ages) {
            numAges[age]++;
        }

        for (int i=1; i<sumAges.length; i++) {
            sumAges[i] = sumAges[i-1]+numAges[i];
        }

        for (int i=15; i<=120; i++) {
            if (numAges[i]!=0) {
                int count = sumAges[i] - sumAges[i/2+7];
                ans+= count*numAges[i]-numAges[i];
            }
        }
        return ans;
    }
}
