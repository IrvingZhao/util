package com.lasun.association.platform.util.weixin.enums;

/**
 * 消息加密类型
 * <ul>
 * <li>CONTENT - 不加密</li>
 * <li>CONTENT_SECURITY - 兼容模式，包含明文好和密文</li>
 * <li>SECURITY - 加密模式，仅包含密文</li>
 * </ul>
 *
 * @author 赵嘉楠
 */
public enum WeChartMessageSecurityType {
    CONTENT, CONTENT_SECURITY, SECURITY;
}
