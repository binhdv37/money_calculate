public class Main {

    public static void main(String[] args) {
        Double currentSalary = (double) 23;
        Double increaseSalaryPercent = (double) 5;
        Double savedFromSalaryPercent = (double) 40;
        Double interestRate = (double) 9;
        int yearCount = 10;
        int currentYear = 2023;
        Double result = cal(currentSalary, increaseSalaryPercent, savedFromSalaryPercent, interestRate, yearCount, currentYear);
        System.out.println("RESULT: " + result);
    }

    private static Double cal(Double currentSalary, Double increaseSalaryPercent, Double savedFromSalaryPercent, Double interestRate, int yearCount, int currentYear) {
        Double result = (double) 0;
        for (int i = 0; i < yearCount; i++) {
            Double savedCurrentYear = calSavedCurrentYear(result, currentSalary, savedFromSalaryPercent, interestRate);
            System.out.println("Must save salary monthly: " + (currentSalary * savedFromSalaryPercent) / 100);
            System.out.println("Can spent salary monthly: " + (currentSalary * (100 - savedFromSalaryPercent)) / 100);
            System.out.println("year " + (i + 1) + " (" + currentYear + ") : " + savedCurrentYear);
            System.out.println("\n");
            result += savedCurrentYear;
            currentSalary = currentSalary + (currentSalary * increaseSalaryPercent / 100);
            currentYear++;
        }
        return result;
    }

    private static Double calSavedCurrentYear(Double savedFromLastYear, Double currentSalary, Double savedFromSalaryPercent, Double interestRate) {
        Double savedFromSalary = (12 * currentSalary) * (savedFromSalaryPercent / 100);
        Double savedFromInterestRate = (savedFromSalary + savedFromLastYear) * (interestRate / 100);
        System.out.println("----------------------------");
        System.out.println("savedFromLastYear: " + savedFromLastYear + " ; currentSalary: " + currentSalary + " ; savedFromSalaryPercent: " + savedFromSalaryPercent + " ; interestRate: " + interestRate);
        System.out.println("savedFromSalary: " + savedFromSalary + " ; savedFromInterestRate: " + savedFromInterestRate);
        return savedFromSalary + savedFromInterestRate;
    }

}
