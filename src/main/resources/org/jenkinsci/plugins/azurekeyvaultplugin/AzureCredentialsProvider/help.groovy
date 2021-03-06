/*
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2020 Microsoft Corporation
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.jenkinsci.plugins.azurekeyvaultplugin.AzureCredentialsProvider

import com.cloudbees.plugins.credentials.CredentialsProvider
import hudson.security.ACL

div() {
    text(_("Provides credentials from Azure Key Vault. "))
    text(_("Credentials will be available to: "))
    ul() {
        li() {
            text(_("Authentication: "))
            code() {
                text(ACL.SYSTEM.name)
            }
        }
        def p = CredentialsProvider.USE_ITEM
        while (p!=null && !p.enabled) {
            p = p.impliedBy
        }
        if (p != null) {
            li() {
                text(_("Users with permission: "))
                code() {
                    text(p.group.title)
                    text("/")
                    text(p.name)
                }
            }
        }
    }
    text(_("Credentials will be available in: "))
    ul(){
        li(_("Global scoped credentials will be available to all items within Jenkins"))
    }
}
