/*
 * Copyright 2019 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.datamodels.core.validation.rules.invalid.format;

import io.apicurio.datamodels.core.Constants;
import io.apicurio.datamodels.core.models.common.License;
import io.apicurio.datamodels.core.validation.ValidationRule;
import io.apicurio.datamodels.core.validation.ValidationRuleMetaData;

/**
 * Implements the Invalid License URL Rule
 * @author eric.wittmann@gmail.com
 */
public class OasInvalidLicenseUrlRule extends ValidationRule {

    /**
     * Constructor.
     * @param ruleInfo
     */
    public OasInvalidLicenseUrlRule(ValidationRuleMetaData ruleInfo) {
        super(ruleInfo);
    }
    
    /**
     * @see io.apicurio.datamodels.combined.visitors.CombinedAllNodeVisitor#visitLicense(io.apicurio.datamodels.core.models.common.License)
     */
    @Override
    public void visitLicense(License node) {
        if (hasValue(node.url)) {
            this.reportIfInvalid(isValidUrl(node.url), node, Constants.PROP_URL, map());
        }
    }

}
