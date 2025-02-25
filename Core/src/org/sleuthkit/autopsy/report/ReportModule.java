/*
 *
 * Autopsy Forensic Browser
 * 
 * Copyright 2012-2019 Basis Technology Corp.
 * 
 * Copyright 2012 42six Solutions.
 * Contact: aebadirad <at> 42six <dot> com
 * Project Contact/Architect: carrier <at> sleuthkit <dot> org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.report;

import javax.swing.JPanel;

/**
 * Interface for report modules that plug in to the reporting infrastructure.
 */
interface ReportModule {

    /**
     * Get the name of the report this module generates.
     */
    public String getName();

    /**
     * Gets a one-line, user friendly description of the type of report this
     * module generates.
     */
    public String getDescription();

    /**
     * Gets the relative path of the report file, if any, generated by this
     * module. The path should be relative to the location that gets passed in
     * to generateReport() (or similar).
     *
     * @return Relative path to where report will be stored. Return an empty
     * string if the location passed to generateReport() is the output location.
     * Return null to indicate that there is no report file.
     */
    public String getRelativeFilePath();

    /**
     * Returns the configuration panel for the report, which is displayed in the
     * report configuration step of the report wizard.
     *
     * @return Configuration panel or null if the module does not need
     * configuration.
     */
    public default JPanel getConfigurationPanel() {
        return new DefaultReportConfigurationPanel();
    }
}
