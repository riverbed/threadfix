////////////////////////////////////////////////////////////////////////
//
//     Copyright (c) 2009-2014 Denim Group, Ltd.
//
//     The contents of this file are subject to the Mozilla Public License
//     Version 2.0 (the "License"); you may not use this file except in
//     compliance with the License. You may obtain a copy of the License at
//     http://www.mozilla.org/MPL/
//
//     Software distributed under the License is distributed on an "AS IS"
//     basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
//     License for the specific language governing rights and limitations
//     under the License.
//
//     The Original Code is ThreadFix.
//
//     The Initial Developer of the Original Code is Denim Group, Ltd.
//     Portions created by Denim Group, Ltd. are Copyright (C)
//     Denim Group, Ltd. All Rights Reserved.
//
//     Contributor(s): Denim Group, Ltd.
//
////////////////////////////////////////////////////////////////////////

package com.denimgroup.threadfix.cli;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

public class OptionsHolder {

    @SuppressWarnings("static-access")
    public static Options getOptions() {
        Options options = new Options();

        Option teams = OptionBuilder.withLongOpt("teams")
                .withDescription("Fetches a list of ThreadFix teams and applications.")
                .create("t");
        options.addOption(teams);

        Option teamsPrettyPrint = OptionBuilder.withLongOpt("teamsPrettyPrint")
                .withDescription("Fetches a human readable list of ThreadFix teams, applications, and application IDs.")
                .create("tpp");
        options.addOption(teamsPrettyPrint);

        options.addOption(new Option("help", "Print this message" ));

        Option set = OptionBuilder.withArgName("property> <value")
                .withValueSeparator(' ')
                .hasArgs(2)
                .withLongOpt("set")
                .withDescription("Set either the url (ThreadFix base url) or key (ThreadFix API key) properties")
                .create("s");
        options.addOption(set);

        Option search = OptionBuilder.withValueSeparator(' ')
                .hasOptionalArgs()
                .withLongOpt("vulnerabilitySearch")
                .withDescription("Query the vulnerabilities using various optional parameters. More information can " +
                        "be found at https://github.com/denimgroup/threadfix/wiki/Threadfix-REST-Interface")
                .create("search");
        options.addOption(search);

        Option queueScan = OptionBuilder.withArgName("applicationId> <scannerName")
                .withValueSeparator(' ')
                .hasArgs(2)
                .withLongOpt("queueScan")
                .withDescription("Queue a scan for the given applicationId with the given scanner type")
                .create("q");
        options.addOption(queueScan);

        Option addAppUrl = OptionBuilder.withArgName("applicationId> <appUrl")
                .withValueSeparator(' ')
                .hasArgs(2)
                .withLongOpt("addAppUrl")
                .withDescription("Add URL for the given applicationId")
                .create("au");
        options.addOption(addAppUrl);

        Option setTaskConfig = OptionBuilder.withArgName("applicationId> <scannerName> <file")
                .withValueSeparator(' ')
                .hasArgs(3)
                .withLongOpt("setTaskConfig")
                .withDescription("Save the scan configuration for the given applicationId with the given scanner type")
                .create("stc");
        options.addOption(setTaskConfig);

        Option setParameters = OptionBuilder.withArgName("appId> <frameworkType> <repositoryUrl")
                .withValueSeparator(' ')
                .hasArgs(3)
                .withLongOpt("setParameters")
                .withDescription("Set scan parameters. Available parameters can be found with --printScanOptions")
                .create("sp");
        options.addOption(setParameters);

        options.addOption(new Option("printScanOptions", "Prints available scan options"));

        Option createTeam = OptionBuilder.withArgName("name")
                .hasArg()
                .withLongOpt("create-team")
                .withDescription("Creates a ThreadFix team and returns its JSON.")
                .create("ct");
        options.addOption(createTeam);

        Option createApp = OptionBuilder.withArgName("teamId> <name> <url")
                .withValueSeparator(' ')
                .hasArgs(3)
                .withLongOpt("create-app")
                .withDescription("Creates a ThreadFix application and returns its JSON.")
                .create("ca");
        options.addOption(createApp);

        Option createWaf = OptionBuilder.withArgName("name> <wafTypeName")
                .withValueSeparator(' ')
                .hasArgs(2)
                .withLongOpt("create-waf")
                .withDescription("Creates a ThreadFix WAF and returns its JSON.")
                .create("cw");
        options.addOption(createWaf);

        Option searchTeam = OptionBuilder.withArgName("property> <value")
                .withValueSeparator(' ')
                .hasArgs(2)
                .withLongOpt("search-team")
                .withDescription("Searches for a ThreadFix team and returns its JSON.")
                .create("st");
        options.addOption(searchTeam);

        Option searchWaf = OptionBuilder.withArgName("property> <value")
                .withValueSeparator(' ')
                .hasArgs(2)
                .withLongOpt("search-waf")
                .withDescription("Searches for a ThreadFix WAF and returns its JSON.")
                .create("sw");
        options.addOption(searchWaf);

        Option searchApp = OptionBuilder.withArgName("property> <value1> <value2")
                .withValueSeparator(' ')
                .hasArgs(3)
                .withLongOpt("search-app")
                .withDescription("Searches for a ThreadFix application and returns its JSON.")
                .create("sa");
        options.addOption(searchApp);

        Option upload = OptionBuilder.withArgName("appId> <file")
                .withValueSeparator(' ')
                .hasArgs(2)
                .withLongOpt("upload")
                .withDescription("Uploads a scan to the specified application.")
                .create("u");
        options.addOption(upload);

        Option getRules = OptionBuilder.withArgName("wafId")
                .hasArg()
                .withLongOpt("rules")
                .withDescription("Gets WAF Rules and returns its JSON.")
                .create("r");
        options.addOption(getRules);

        Option getRulesForApp = OptionBuilder.withArgName("wafId> <applicationId")
                .hasArgs(2)
                .withLongOpt("rules-for-application")
                .withDescription("Gets WAF Rules for an application and returns its JSON.")
                .create("ra");
        options.addOption(getRulesForApp);

        return options;
    }

}
