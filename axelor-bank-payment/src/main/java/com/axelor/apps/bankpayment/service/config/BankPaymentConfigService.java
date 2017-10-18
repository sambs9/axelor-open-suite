/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2017 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.bankpayment.service.config;

import com.axelor.apps.account.db.Account;
import com.axelor.apps.account.db.AccountConfig;
import com.axelor.apps.account.service.app.AppAccountServiceImpl;
import com.axelor.apps.account.service.config.AccountConfigService;
import com.axelor.apps.bankpayment.db.BankPaymentConfig;
import com.axelor.apps.bankpayment.exception.IExceptionMessage;
import com.axelor.apps.base.db.Company;
import com.axelor.apps.base.db.Sequence;
import com.axelor.apps.base.service.app.AppBaseServiceImpl;
import com.axelor.auth.db.User;
import com.axelor.exception.AxelorException;
import com.axelor.exception.db.IException;
import com.axelor.i18n.I18n;

public class BankPaymentConfigService  {

	public BankPaymentConfig getBankPaymentConfig(Company company) throws AxelorException  {
		BankPaymentConfig bankPaymentConfig = company.getBankPaymentConfig();
		if (bankPaymentConfig == null) {
			throw new AxelorException(IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_1), AppAccountServiceImpl.EXCEPTION,company.getName());
		}
		return bankPaymentConfig;
	}

	public Account getExternalBankToBankAccount(BankPaymentConfig bankPaymentConfig) throws AxelorException  {
		if (bankPaymentConfig.getExternalBankToBankAccount() == null) {
			throw new AxelorException(bankPaymentConfig, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_EXTERNAL_BANK_TO_BANK_ACCOUNT), AppBaseServiceImpl.EXCEPTION,bankPaymentConfig.getCompany().getName());
		}
		return bankPaymentConfig.getExternalBankToBankAccount();
	} 
	
	public Account getInternalBankToBankAccount(BankPaymentConfig bankPaymentConfig) throws AxelorException  {
		if (bankPaymentConfig.getInternalBankToBankAccount() == null) {
			throw new AxelorException(bankPaymentConfig, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_INTERNAL_BANK_TO_BANK_ACCOUNT), AppBaseServiceImpl.EXCEPTION,bankPaymentConfig.getCompany().getName());
		}
		return bankPaymentConfig.getInternalBankToBankAccount();
	} 


    /******** Bank Order Sequences ********/
	public Sequence getSepaCreditTransSequence(BankPaymentConfig bankPaymentConfig) throws AxelorException {
		if (bankPaymentConfig.getSepaCreditTransSequence() == null) {
			throw new AxelorException(bankPaymentConfig, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_SEQUENCE_5), AppBaseServiceImpl.EXCEPTION, bankPaymentConfig.getCompany().getName());
		}
		return bankPaymentConfig.getSepaCreditTransSequence();
	}

	public Sequence getSepaDirectDebitSequence(BankPaymentConfig bankPaymentConfig) throws AxelorException {
		if (bankPaymentConfig.getSepaDirectDebitSequence() == null) {
			throw new AxelorException(bankPaymentConfig, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_SEQUENCE_6), AppBaseServiceImpl.EXCEPTION, bankPaymentConfig.getCompany().getName());
		}
		return bankPaymentConfig.getSepaDirectDebitSequence();
	}

	public Sequence getIntCreditTransSequence(BankPaymentConfig bankPaymentConfig) throws AxelorException {
		if (bankPaymentConfig.getIntCreditTransSequence() == null) {
			throw new AxelorException(bankPaymentConfig, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_SEQUENCE_7), AppBaseServiceImpl.EXCEPTION, bankPaymentConfig.getCompany().getName());
		}
		return bankPaymentConfig.getIntCreditTransSequence();
	}

	public Sequence getIntDirectDebitSequence(BankPaymentConfig bankPaymentConfig) throws AxelorException {
		if (bankPaymentConfig.getIntDirectDebitSequence() == null) {
			throw new AxelorException(bankPaymentConfig, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_SEQUENCE_8), AppBaseServiceImpl.EXCEPTION, bankPaymentConfig.getCompany().getName());
		}
		return bankPaymentConfig.getIntDirectDebitSequence();
	}
	
	public Sequence getNatTreasuryTransSequence(BankPaymentConfig bankPaymentConfig) throws AxelorException {
		if (bankPaymentConfig.getNatTreasuryTransSequence() == null) {
			throw new AxelorException(bankPaymentConfig, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_SEQUENCE_9), AppBaseServiceImpl.EXCEPTION, bankPaymentConfig.getCompany().getName());
		}
		return bankPaymentConfig.getNatTreasuryTransSequence();
	}
	
	public Sequence getIntTreasuryTransSequence(BankPaymentConfig bankPaymentConfig) throws AxelorException {
		if (bankPaymentConfig.getIntTreasuryTransSequence() == null) {
			throw new AxelorException(bankPaymentConfig, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_SEQUENCE_10), AppBaseServiceImpl.EXCEPTION, bankPaymentConfig.getCompany().getName());
		}
		return bankPaymentConfig.getIntTreasuryTransSequence();
	}
	
	public Sequence getOtherBankOrderSequence(BankPaymentConfig bankPaymentConfig) throws AxelorException {
		if (bankPaymentConfig.getOtherBankOrderSequence() == null) {
			throw new AxelorException(bankPaymentConfig, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_SEQUENCE_11), AppBaseServiceImpl.EXCEPTION, bankPaymentConfig.getCompany().getName());
		}
		return bankPaymentConfig.getOtherBankOrderSequence();
	}
	
	
	/******************************** BANK ORDERS *********************************************/
	public User getDefaultSignatoryUser(BankPaymentConfig bankPaymentConfig) throws AxelorException {
		if (bankPaymentConfig.getDefaultSignatoryUser() == null) {
			throw new AxelorException(bankPaymentConfig, IException.CONFIGURATION_ERROR, I18n.get(IExceptionMessage.ACCOUNT_CONFIG_41), AppBaseServiceImpl.EXCEPTION,bankPaymentConfig.getCompany().getName());
		}
		return bankPaymentConfig.getDefaultSignatoryUser();
	}
	
}
