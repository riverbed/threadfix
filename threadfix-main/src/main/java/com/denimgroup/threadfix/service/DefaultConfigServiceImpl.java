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

package com.denimgroup.threadfix.service;

import com.denimgroup.threadfix.data.dao.DefaultConfigurationDao;
import com.denimgroup.threadfix.data.entities.DefaultConfiguration;
import com.denimgroup.threadfix.logging.SanitizedLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultConfigServiceImpl implements DefaultConfigService {
	
	protected final SanitizedLogger log = new SanitizedLogger(DefaultConfigServiceImpl.class);
	
	@Autowired
	private DefaultConfigurationDao defaultConfigurationDao;

	@Override
	public DefaultConfiguration loadCurrentConfiguration() {
		List<DefaultConfiguration> list = defaultConfigurationDao.retrieveAll();
		if (list.size() == 0) {
            return DefaultConfiguration.getInitialConfig();
		}
		
		if (list.size() > 1) {
			DefaultConfiguration config = list.get(0);
			list.remove(0);
			for (DefaultConfiguration defaultConfig : list) {
				defaultConfigurationDao.delete(defaultConfig);
			}
			return config;
		}
		
		return list.get(0);
	}

	@Override
	public void saveConfiguration(DefaultConfiguration config) {
		defaultConfigurationDao.saveOrUpdate(config);
	}

    @Override
    public boolean isReportCacheDirty() {
        return !loadCurrentConfiguration().getHasCachedData();
    }

}
