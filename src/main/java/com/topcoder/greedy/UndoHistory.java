/**
 *
 */
package com.topcoder.greedy;

/**
 * @author piyush
 */
public class UndoHistory {


    /**
     * @param args
     */
    public static void main(String[] args) {
        String lines[] = {"sqqsqrttpptssrsptrsrsspssppqtspttrqstpstrqprsttrt",
                "sqqsqrttpptssrsptrstrpr",
                "sqprqpqsprsspqsrrrsrqqpqt",
                "sqqsqrttpptssrsptrstrptrrsstptts",
                "qqstpsssrpqtpqtsppqqqtprrrtpsqtpqspptrrsrsrtrqsqsr",
                "sqqsqrttpptssrsptrsrsspsspptptqsqsrpsspqsttrp",
                "qprqqttqpsrtqprrsrqrqqtspqttssqqqqsrttpqssstpsrtqr",
                "rqrrqsqqstsqrqtsqrrqpqqsptrptrtsspqqttttspqptprp",
                "rpprttsqrsqptrtpqpptrqtqqspspptpqrtpqtpsqstsppqsrq",
                "sqqsqrttpptssrstprsssprtrstsqrqrstqqssqspptqr",
                "ssqsrrpqqttpqppsqtstrrqsttqqrqrsprtsspsqpsttttrs",
                "sqqsqrttpptssrstprsssprtrstsqrqrstqqssqqqrsppsqq",
                "pstpprpsqqppqsspsprrqspqsqrrqqtpqpptrsspptpppssp",
                "sqqsqrttpptssrstprsssprqtprpqqtrsrqtssprttqtprpsrt",
                "ppstqrtqsrtrqtrpttssrstssrqrrqrrqsqtrqstqtrstrqsp",
                "sqqsqrttp",
                "rqrqrqpqpstrqrrprqqqpptsrpqsrrsrpprtrtppqsttprtp",
                "ssqtqsptsrqrrtpqprsptqrppqsqqsrtrprptspspsqrrpppps",
                "sqqrsqprsssqttttqs",
                "sqqsqrttpptssrstprsssprtrstsqrqprsssss",
                "sqprqqrsrsqrtqprrqqqttqpsppspssqrqprstrrqrqs",
                "sqqppsrrpsqrpqsqppqqqptppq",
                "ttqqsqrpstqqsqsqrtptqtqptprrtrrtppspqstqrtrqqrtsr",
                "sqrqrpqqsptqrqqqtqqtqtssqqqtsrstqrsqrrptsqtprtpspr",
                "sqqsqrqrtqsrrqqsrtsstptssqqqpprstt",
                "sqqsqrttpptssrsptrsrsspsspptptqsqsrpstprssqsttqpqr",
                "qpqsrsrtsttrpsqttpqstpsqqpspsqrtqttpptttspqsptps",
                "qqstpsssrpqtpqtsppqqqtprrrtpsqtpqspptrrsrsrtrqsqs",
                "qprqqttqpsrtqprrsrqrqqtspqttssqqqqsrttp",
                "sqprqpqsprsspqpqqtqstrtttpsttttqqtrssqspqppq",
                "sqprqqrsrsqrtqprrqqs",
                "sqrppttsrqprsqqrsttrtqrqpqsqprsqtr",
                "sqqsqrttpptssrstprsssprtrstssqt",
                "ttqqsqrpstqqsqsqrptpppstpqqssrtqsrttqtqt",
                "ptqqrqpsptrpsrtrttppptprtrsqrttsssssrqtpqtrspsqstq",
                "sqrqrpqqsptqrqqqtqqtqqpspstttrssqrqqpqrqqprqqpr",
                "pstpprpsqqpsqrqsqrqtst",
                "srstsqqtqrpqqppppptqsrqqptttsqsssssrtstppssrsprqt",
                "sqqqtpqprqsqrpqprrqtrrrtsqrtqrsrst",
                "rpprrqpr",
                "sqprqqrsrsqrtqprrqqqttqpsppspssqrqprstrrqrtt",
                "ttptsssrssrqsqpqtpspstqpprsrtqpprpsstrtptqtsqtrts",
                "sqqsqrqrtqsrrqqsrtsstptssqqqpprsst",
                "rtprprtpsttqtrqqttrpppsqqpqprrrrqqqqsqtpststpqrt",
                "ttptsssrssrqsqpqtpspstqpprsrtqpprpsstrqrtrt",
                "sqqqtpqprqsqrpqprrqtrrrttqrsprpttrqsqp",
                "ssqppsqstqsrqrsrppptrssqrqqtstqpptprrsprqqpqstqrt",
                "ttptsssrssrqsqpqtpspsprppstpsssptpttrr",
                "spqrtqrrsttssprsrqqptprspqqtttpqqsrqssqqrtqssprqrt"};
        System.out.println(new UndoHistory().minPresses(lines));
    }

    private int mostMatch(String lines[], int i) {
        if (i - 1 < 0) {
            return 0;
        }

        int maxCount = 0;

        for (int j = i - 1; j >= 0; j--) {
            int index = 0;
            while (index < lines[i].length() && index < lines[j].length() && lines[i].charAt(index) == lines[j].charAt(index))
                index++;

            maxCount = Math.max(maxCount, index);
        }

        return maxCount;
    }

    public int minPresses(String[] lines) {
        int count = 0;


        count = lines[0].length() + 1;

        for (int i = 1; i < lines.length; i++) {
            // Start with ith item

            // Check similar letters for i and i-1 such that i-1>=0
            int similarLetters = mostMatch(lines, i);
            int typing = 0;

            typing = lines[i].length() - similarLetters;
            if (lines[i].startsWith(lines[i - 1])) {
                // Undo is not required.
                typing = typing + 1;
            } else {
                typing = typing + 2 + 1;
            }


            count = count + typing;
        }

        return count;
    }

}
