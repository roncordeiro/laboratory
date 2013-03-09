package br.gov.frameworkdemoiselle.analyzer.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ClassUtils;

import br.gov.frameworkdemoiselle.util.Reflections;

public class MemoryAnalyzer {

	private MemoryAnalyzer() {
	}

	public static Node analyze(Object instance) throws Exception {
		return check(instance);
	}

	private static Node check(Object target) throws Exception {
		return check(target.getClass().getName(), target, target.getClass(), null, new HashSet<Object>());
	}

	private static Node check(String name, final Object target, final Class<?> type, Node parent,
			Set<Object> visitedInstances) throws Exception {
		// long result = size;
		visitedInstances.add(target);
		Node node = new Node(name, type, parent);

		if (isPrimitiveOrWrapper(type)) {
			node.setSize(getSize(target));
			//
			// long objectSize = ;
			// result += objectSize;
			//
			// new Node(name, objectSize);

			// println(getTabulation(nestedCount) + name + " (" + objectSize + ")");

		} else {
			// println(getTabulation(nestedCount) + name);

			if (target instanceof Collection<?>) {
				checkCollection(name, (Collection<?>) target, node, visitedInstances);
			} else if (target instanceof Map<?, ?>) {
				checkMap(name, (Map<?, ?>) target, node, visitedInstances);
			} else {
				checkBean(target, type, node, visitedInstances);
			}

			// println(getTabulation(nestedCount) + "(" + result + ")");
		}

		// return result;
		return node;
	}

	private static boolean isPrimitiveOrWrapper(Class<?> type) {
		boolean result = false;

		result |= type.isPrimitive();
		result |= ClassUtils.wrapperToPrimitive(type) != null;
		result |= type == String.class;
		result |= type == Class.class;

		return result;
	}

	private static void checkCollection(String name, Collection<?> target, Node parent, Set<Object> visitedInstances)
			throws Exception {
		try {
			int i = 0;
			for (Object item : target) {
				if (item != null) {
					check("[" + i + "]", item, item.getClass(), parent, visitedInstances);
				}
				i++;
			}

		} catch (Exception cause) {
			// println("Falha ao tentar acessar a Collection com o seguinte erro: " + cause.getMessage());
		}
	}

	private static void checkMap(String name, Map<?, ?> target, Node parent, Set<Object> visitedInstances)
			throws Exception {
		try {
			for (Object key : target.keySet()) {
				if (target.get(key) != null) {
					check("[" + key + "]", target.get(key), target.get(key).getClass(), parent, visitedInstances);
				}
			}

		} catch (Exception cause) {
			// println("Falha ao tentar acessar o Map com o seguinte erro: " + cause.getMessage());
		}
	}

	private static void checkBean(Object target, Class<?> type, Node parent, Set<Object> visitedInstances)
			throws Exception {
		Object value;
		for (Field field : getNonStaticDeclaredFields(type)) {
			value = getValue(field, target);

			if (value != null && !visitedInstances.contains(value)) {
				check(field.getName(), value, field.getType(), parent, visitedInstances);
			}
		}
	}

	private static List<Field> getNonStaticDeclaredFields(Class<?> type) {
		List<Field> fields = new ArrayList<Field>();

		if (type != null) {
			fields.addAll(Arrays.asList(Reflections.getNonStaticDeclaredFields(type)));
			fields.addAll(getNonStaticDeclaredFields(type.getSuperclass()));
		}

		return fields;
	}

	private static Object getValue(Field field, Object target) throws Exception {
		Object fieldValue;

		// try {
		// fieldValue = PropertyUtils.getProperty(target, field.getName());
		//
		// } catch (NoSuchMethodException cause) {
		boolean accessible = field.isAccessible();
		field.setAccessible(true);
		fieldValue = field.get(target);
		field.setAccessible(accessible);
		// }

		return fieldValue;
	}

	private static int getSize(Object target) throws IOException {
		ByteArrayOutputStream byteObject = new ByteArrayOutputStream();

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteObject);
			objectOutputStream.writeObject(target);
			objectOutputStream.flush();
			objectOutputStream.close();
			byteObject.close();

		} catch (NotSerializableException cause) {
			// println("Falha ao tentar serializar " + cause.getMessage());
		}

		return byteObject.size();
	}

	// private static void println(String message) {
	// if (buffer == null) {
	// buffer = new StringBuffer();
	// }
	//
	// buffer.append(message + "\n");
	// }

	// private void print(Node node) {
	// println(getTabulation(node.getLevel()) + node.getName() + " (" + node.getSize() + " bytes)");
	//
	// for (Node child : node.getChildren()) {
	// print(child);
	// }
	//
	// if (node.getParent() == null) {
	// logger.info(buffer.toString());
	// }
	// }

}


