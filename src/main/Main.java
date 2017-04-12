/*******************************************************************************
 * Copyright (C) 2017 Benedek Racz
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package main;

import org.apache.commons.cli.*;

/**
 * 
 * @author Benedek Racz
 *
 */
public class Main {

	/**
	 * The public main function.
	 * @param args
	 */
	public static void  main(String[] args) {
		System.out.println("Starting");
		
		Options options = new Options();

        Option input = new Option("s", "solution", true, "This will be the "
        		+ "solution of the cross word game. (aka. This will be the first"
        		+ " vertical word on the canvas.)");

        Option numOfBatchOption = new Option("n", "numOfBatch", true, "");
        
//        numOfBatch.s;
        options.addOption(input);
        options.addOption(numOfBatchOption);
        
		CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
            return;
        }

		System.out.println(cmd.getArgList());

        String solution = cmd.getOptionValue("solution");
		int numOfBatch = Integer.valueOf(cmd.getOptionValue("numOfBatch", "200"));
		System.out.println(solution);
		Generator gen = new Generator(solution);	// <---- EDIT THIS LINE FOR DIFFERENT SOLUTIONS.
		long startTime = System.currentTimeMillis();
		gen.generate(numOfBatch);
		long estimatedTime = System.currentTimeMillis() - startTime;
		System.out.print("estimatedTime: " + estimatedTime + "ms");
	}

}
