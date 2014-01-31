/*
 * Demoiselle Framework
 * Copyright (C) 2014 SERPRO
 * ----------------------------------------------------------------------------
 * This file is part of Demoiselle Framework.
 * 
 * Demoiselle Framework is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License version 3
 * along with this program; if not,  see <http://www.gnu.org/licenses/>
 * or write to the Free Software Foundation, Inc., 51 Franklin Street,
 * Fifth Floor, Boston, MA  02110-1301, USA.
 * ----------------------------------------------------------------------------
 * Este arquivo é parte do Framework Demoiselle.
 * 
 * O Framework Demoiselle é um software livre; você pode redistribuí-lo e/ou
 * modificá-lo dentro dos termos da GNU LGPL versão 3 como publicada pela Fundação
 * do Software Livre (FSF).
 * 
 * Este programa é distribuído na esperança que possa ser útil, mas SEM NENHUMA
 * GARANTIA; sem uma garantia implícita de ADEQUAÇÃO a qualquer MERCADO ou
 * APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU/LGPL em português
 * para maiores detalhes.
 * 
 * Você deve ter recebido uma cópia da GNU LGPL versão 3, sob o título
 * "LICENCA.txt", junto com esse programa. Se não, acesse <http://www.gnu.org/licenses/>
 * ou escreva para a Fundação do Software Livre (FSF) Inc.,
 * 51 Franklin St, Fifth Floor, Boston, MA 02111-1301, USA.
 */
package br.gov.frameworkdemoiselle.component.audit.dashboard.business;

import java.util.Date;
import java.util.List;

import br.gov.frameworkdemoiselle.component.audit.dashboard.persistence.TrailDAO;
import br.gov.frameworkdemoiselle.component.audit.domain.Trail;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

/**
 * 
 * @author SERPRO
 * 
 */

@BusinessController
public class TrailBC extends DelegateCrud<Trail, Long, TrailDAO> {
	
	private static final long serialVersionUID = 1L;

	public List<Trail> findByNamedQuery(String namedQuery, String param, String value) {
    	return getDelegate().findByNamedQuery(namedQuery, param, value);
    }

    public List<String> findByNamedQueryDistinct(String namedQuery) {
        return getDelegate().findByNamedQueryDistinct(namedQuery);
    }
    
    public List<String> findByNamedQueryDistinct(String namedQuery, String param, String value) {
		return getDelegate().findByNamedQueryDistinct(namedQuery, param, value);
	}

    public List<Trail> findByNamedQueryWithBetween(String namedQuery, String param, String value, Date dateBegin, Date dateFinal) {
        return getDelegate().findByNamedQueryWithBetween(namedQuery, param, value, dateBegin, dateFinal);
    }

	public String findByNamedQueryIdName(String namedQuery, String systemName, String className) {
		return getDelegate().findByNamedQueryIdName(namedQuery, systemName, className);
	}

	public List<Trail> findByNamedQuerySystemAndObjectAndIdName(String namedQuery,
			String system, String object, String objectIdName,
			String objectIdValue) {
		return getDelegate().findByNamedQuerySystemAndObjectAndIdName(namedQuery, system, object, objectIdName, objectIdValue);
	}

    
}
